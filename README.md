# Electric Starter App (Electric v2)

## Demo with CSS-only DaisyUI & TailwindCSS

DaisyUI provides some CSS-only 'components' based on Tailwind.

If you do the setup below, you can run the tailwind style watcher in one process, and have live CSS updates in your electric app:

* `npm run build:tailwind:dev`
* `clj -A:dev -X dev/-main`, or repl: `(dev/-main)`

## DaisyUI / TailwindCSS Instructions

* DaisyUI instructions at: [https://daisyui.com/docs/install/]()
* Requires tailwind installed: [https://tailwindcss.com/docs/installation]()

```bash
npm init
npm i -D tailwindcss
npx tailwindcss init
# add some plugins if you want
npm i -D @tailwindcss/forms @tailwindcss/typography
# add daisyui
npm i -D daisyui@latest
```

* edit tailwind config, add `daisyui` plugin, themes if you want, and the content path to your clojure code `./src/**/*`
* The tailwind watcher seems to parse the source ok

```js
/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*",
    "./resources/public/halo_electric/index.html"
  ],
  theme: {
    extend: {},
  },
  plugins: [
    // require('@tailwindcss/forms'),
    // require('@tailwindcss/typography'),
    require('daisyui'),
  ],
  daisyui: {
    themes: ["lemonade"],
  },
}
```

* add your tailwind input (eg `input.css`) to `resources/input.css`
```css
@tailwind base;
@tailwind components;
@tailwind utilities;
```

* the output file name (eg `styles.css`) and your theme (`data-theme`) to your `index.html`
```html
<html data-theme="corporate">
...
    <link href="./styles.css" rel="stylesheet">
```

* some npm scripts in `package.json` to run the watcher or build
```json
  "scripts": {
    "build:tailwind:dev": "npx tailwindcss -i ./resources/input.css -o ./resources/public/electric_starter_app/styles.css --watch",
    "build:tailwind": "npx tailwindcss -i ./resources/input.css -o ./resources/public/electric_starter_app/styles.css --minify",
  },
```


## Instructions

Dev build:

* Shell: `clj -A:dev -X dev/-main`, or repl: `(dev/-main)`
* http://localhost:8080
* Electric root function: [src/electric_starter_app/main.cljc](src/electric_starter_app/main.cljc)
* Hot code reloading works: edit -> save -> see app reload in browser

Prod build:

```shell
clj -X:build:prod build-client
clj -M:prod -m prod
```

Uberjar (optional):
```
clj -X:build:prod uberjar :build/jar-name "target/app.jar"
java -cp target/app.jar clojure.main -m prod
```

Deployment example:
- [Dockerfile](Dockerfile)
- fly.io deployment through github actions: [.github/workflows/deploy.yml](.github/workflows/deploy.yml) & [fly.toml](fly.toml)

## Integrate it in an existing clojure app

1. Look at [src-prod/prod.cljc](src-prod/prod.cljc). It contains:
    - server entrypoint
    - client entrypoint
    - necessary configuration
2. Look at [src/electric_starter_app/server_jetty.clj](src/electric_starter_app/server_jetty.clj). It contains:
   - an example Jetty integration
   - required ring middlewares

## Build documentation

Electric Clojure programs compile down to separate client and server target programs, which are compiled from the same Electric application source code.

* For an Electric client/server pair to successfully connect, they must be built from matching source code. The server will reject mismatched clients (based on a version number handshake coordinated by the Electric build) and instruct the client to refresh (to get the latest javascript artifact).
* [src-build/build.cljc](src-build/build.clj bakes the Electric app version into both client and server artifacts.
  * server Electric app version is baked into `electric-manifest.edn` which is read in [src-prod/prod.cljc](src-prod/prod.cljc).
  * client Electric app version is baked into the .js artifact as `hyperfiddle.electric-client/ELECTRIC_USER_VERSION`

Consequently, you need **robust cache invalidation** in prod!
  * In this example, complied js files are fingerprinted with their respective hash, to ensure a new release properly invalidates asset caches. [index.html](resources/public/electric_starter_app/index.html) is templated with the generated js file name.
  * The generated name comes from shadow-cljs's `manifest.edn` file (in `resources/public/electric_starter_app/js/manifest.edn`), produced by `clj -X:build:prod build-client`. Watch out: this shadow-cljs compilation manifest is not the same manifest as `electric-manifest.edn`!
  * Notice that [src/electric_starter_app/server_jetty.clj](src/electric_starter_app/server_jetty.clj) -> `wrap-index-page` reads `:manifest-path` from config. The config comes from [src-prod/prod.cljc](src-prod/prod.cljc).

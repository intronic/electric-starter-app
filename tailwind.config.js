/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*",
    "./resources/public/electric_starter_app/index.html",
    "node_modules/preline/dist/*.js"
  ],
  theme: {
    extend: {},
  },
  plugins: [
    require('@tailwindcss/forms'),
    // require('@tailwindcss/typography'),
    require('preline/plugin'),
  ],
}

/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*",
    "./resources/public/electric_starter_app/index.html"
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
    themes: ["lemonade", "light", "dark", "corporate", "cyberpunk"],
  },

}

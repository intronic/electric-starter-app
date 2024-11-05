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
    themes: ["lemonade", "light", "dark", "corporate", "cyberpunk",
      {
        tailwindui: {
          "primary": "#4f46e5", // "indigo-600",
          // "primary-content": "", // all the matching *-content colours will default
          "secondary": "#0ea5e9", // "sky-500",
          "accent": "#f3f4f6", // "gray-100",
          "neutral": "#f9fafb", // "gray-50",
          "base-100": "white",
          // Other options
          // "--rounded-box": "1rem", // border radius rounded-box utility class, used in card and other large boxes
          // "--rounded-btn": "0.5rem", // border radius rounded-btn utility class, used in buttons and similar element
          // "--rounded-badge": "1.9rem", // border radius rounded-badge utility class, used in badges and similar
          // "--animation-btn": "0.25s", // duration of animation when you click on button
          // "--animation-input": "0.2s", // duration of animation for inputs like checkbox, toggle, radio, etc
          // "--btn-focus-scale": "0.95", // scale transform of button when you focus on it
          // "--border-btn": "1px", // border width of buttons
          // "--tab-border": "1px", // border width of tabs
          // "--tab-radius": "0.5rem", // border radius of tabs
        }
      },
      {
        prelineui: {
          "primary": "#3b82f6", // blue-500
          "secondary": "#dbeafe", // blue-100
          "neutral": "#f3f4f6", // gray-100
        }
      }
    ],
  },

}

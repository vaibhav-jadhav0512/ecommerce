/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js,jsx,ts,tsx}"],
  theme: {
    extend: {
      fontFamily: { Poppins: "Poppins" },
      colors: {
        dark_purple: "#000235",
        btn_primary: "#7e7ee3",
        heading_color: "#abd9d9",
      },
    },
  },
  plugins: [],
};

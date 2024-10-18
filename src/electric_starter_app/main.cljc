(ns electric-starter-app.main
  (:require [hyperfiddle.electric :as e]
            [hyperfiddle.electric-dom2 :as dom]
            [electric-starter-app.dom :as d]))

;; Saving this file will automatically recompile and update in your browser

(e/defn Search []
  (e/client
    (d/divp {:class "form-control"}
      (dom/input (dom/props {:class "input input-bordered w-24 md:w-auto"
                             :type "text"
                             :placeholder "Search"})))))

(e/defn Menu []
  (e/client
    (d/divp {:class "dropdown dropdown-end"}
      (dom/div (dom/props {:class "btn btn-ghost btn-circle avatar"
                           :tabindex "0" :role "button"})
        (d/divp {:class "w-10 rounded-full"}
          (dom/img (dom/props {:alt "Tailwind CSS Navbar component"
                               :src "https://img.daisyui.com/images/stock/photo-1534528741775-53994a69daeb.webp"}))))
      (dom/ul (dom/props {:class "menu menu-sm dropdown-content bg-base-100 rounded-box z-[1] mt-3 w-52 p-2 shadow"
                          :tabindex "0"})
        (dom/li (dom/props {})
          (dom/a (dom/props {:class "justify-between"})
            (dom/text "Profile")
            (d/spanp {:class "badge"}
              (dom/text "New"))))
        (dom/li (dom/props {})
          (dom/a (dom/props {}) (dom/text "Settings")))
        (dom/li (dom/props {})
          (dom/a (dom/props {}) (dom/text "Logout")))))))

(e/defn NavBar [title Search Menu]
  (e/client
    (d/divp {:class "navbar bg-base-100"}
      (d/divp {:class "flex-1"}
        (dom/a {:class "btn btn-ghost text-xl"
                :href "#"}
          (dom/text title)))
      (d/divp {:class "flex-none gap-2"}
        (Search.)
        (Menu.)))))

(e/defn Card []
  (e/client
    (d/divp {:class "card bg-neutral text-neutral-content w-96"}
      (d/divp {:class "card-body items-center text-center"}
        (dom/h2 (dom/props {:class "card-title"})
          (dom/text "Hello from Electric Clojure"))
        (dom/p (dom/text "Source code for this page is in ")
          (dom/code (dom/text "src/electric_start_app/main.cljc")))
        (dom/p (dom/text "Make sure you check the ")
          (dom/a (dom/props {:href "https://electric.hyperfiddle.net/" :target "_blank"})
            (dom/text "Electric Tutorial")))
        (d/divp {:class "card-actions justify-end"}
          (dom/button (dom/props {:class "btn btn-primary"})
            (dom/text "OK"))
          (dom/button (dom/props {:class "btn btn-secondary"})
            (dom/text "No")))))))

(e/defn Main [ring-request]
  (e/client
    (binding [dom/node js/document.body]
      (NavBar. "Electric Clojure" Search Menu)
      (Card.))))

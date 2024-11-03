(ns electric-starter-app.main
     (:require [hyperfiddle.electric :as e]
               [hyperfiddle.electric-dom2 :as dom]
               [hyperfiddle.electric-svg :as svg]
               [electric-starter-app.preline-header :as ph]))

   #_#?(:cljs (set! *warn-on-infer* true))

;; Saving this file will automatically recompile and update in your browser

;;; NavBar example from: https://preline.co/examples/layouts-application-navbars.html#application-layout-header
;;; See README.md for how Electric DOM code was generated from Preline example HTML

   (defn preline-autoinit
     "Trigger preline to init. Must be done after nodes loaded.
   Preline attaches event handlers to the Electric dom nodes."
     []
     #?(:cljs (do
                (js/console.log "Preline autoInit")
                (.. js/window -HSStaticMethods autoInit))))

   (e/defn Main [ring-request]
     (e/client
       (binding [dom/node js/document.body]
         (ph/NavBar.
           (e/fn []
             (dom/h1 (dom/props {:class "text-2xl font-bold md:text-3xl text-gray-800 dark:text-neutral-200"})
               (dom/text "Hello from Electric Clojure"))
             (dom/p (dom/text "Source code for this page is in ")
               (dom/code (dom/props {:class "text-red-600 text-sm font-mono"})
                 (dom/text "src/electric_start_app/main.cljc")))
             (dom/p (dom/text "Make sure you check the ")
               (dom/a (dom/props {:class "text-blue-600 underline decoration-blue-600 hover:opacity-80 focus:outline-none focus:opacity-80"
                                  :href "https://electric.hyperfiddle.net/" :target "_blank"})
                 (dom/text "Electric Tutorial")))))

         (preline-autoinit))))

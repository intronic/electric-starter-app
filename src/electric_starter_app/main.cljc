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
      (ph/NavBar.)
      (preline-autoinit))))

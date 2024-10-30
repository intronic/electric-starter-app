(ns electric-starter-app.dom
  (:require [hyperfiddle.electric-dom2 :as dom]))

(defmacro divp
  "Shortcut for presentation <div> wrapping props in electric-dom/props, and setting :role :none.
   :role is not strictly necessary but is a reminder to add roles to these elements if used
   in place of semantic tags."
  [props & body]
  `(dom/div (dom/props (assoc ~props :role :none)) ~@body))

(defmacro spanp
  "Shortcut for presentation <span> wrapping props in electric-dom/props, and setting :role :none.
   :role is not strictly necessary but is a reminder to add roles to these elements if are used
   in place of semantic tags."
  [props & body]
  `(dom/span (dom/props (assoc ~props :role :none)) ~@body))

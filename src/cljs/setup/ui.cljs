(ns setup.ui)

(def request-animation-frame (or (.-requestAnimationFrame js/window)
                                 (.-mozRequestAnimationFrame js/window)
                                 (.-webkitRequestAnimationFrame js/window)
                                 (.-msRequestAnimationFrame js/window)
                                 (fn [f] (.setTimeout js/window f 16))))

(def canvas (.getElementById js/document "c"))
(def ctx (.getContext canvas "2d"))
(def image-logo  (atom nil))

(defn x [tick width]
  (-> tick
      (* 0.0035)
      (Math/sin)
      (* width)
      (* 0.15)
      (+ (/ width 2.0))))

(defn y [tick height]
  (-> tick
      (* 0.0020)
      (Math/sin)
      (* height)
      (* 0.2)
      (+ (/ height 2.0))))

(defn r [tick]
  (* tick 0.002))

(defn run [ts]
  (request-animation-frame run)
  (let [image @image-logo
        window-width (.-innerWidth js/window)
        window-height (.-innerHeight js/window)]
    (doto canvas
      (aset "width" window-width)
      (aset "height" window-height))
    (doto ctx
      (.save)
      (aset "fillStyle" "rgb(255,255,255)")
      (.fillRect 0 0 window-width window-height)
      (.translate (x ts window-width)
                  (y ts window-height))
      (.rotate (r ts))
      (.drawImage image
                  (-> image .-width (* -0.5))
                  (-> image .-height (* -0.5)))
      (.restore))))

(defn main []
  (js/console.log "start")
  (let [image (new js/Image)]
    (reset! image-logo image)
    (doto image
      (aset "onload" (partial request-animation-frame run))
      (aset "src" "logo.png"))))

(-> js/window .-onload (set! main))

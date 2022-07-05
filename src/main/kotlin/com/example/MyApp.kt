package com.example

import com.example.view.AuthView
import com.example.view.MainView
import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.App
import tornadofx.addStageIcon
import tornadofx.importStylesheet

class MyApp: App(AuthView::class, Styles::class)
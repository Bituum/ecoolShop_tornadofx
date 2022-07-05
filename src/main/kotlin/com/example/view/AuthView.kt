package com.example.view

import com.example.Styles
import com.example.model.fx.User
import com.example.model.fx.UserModel
import javafx.geometry.Orientation
import javafx.scene.control.Button
import javafx.scene.control.ProgressIndicator
import tornadofx.*
import tornadofx.Form

class AuthView : View("login view") {
    override val root = Form().addClass(Styles.login)
    val model = UserModel(User())

    init {
        with(root) {
            fieldset {
                labelPosition = Orientation.VERTICAL

                field("Username") {
                    textfield(model.username)
                        .required(message = "Insert username")
                }
                field("Password") {
                    passwordfield(model.password)
                        .required(message = "Insert password")
                }
                button("Log in") {
                    setOnAction {
                        performLogin()
                    }
                }
            }
        }
    }

    private fun Button.performLogin() {
        graphic = ProgressIndicator()

        model.commit()
    }

}

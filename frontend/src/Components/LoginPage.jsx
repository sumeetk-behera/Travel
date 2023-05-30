import React, { useState } from "react";
import Grid from "@mui/material/Grid";
import login_img from "../Assets/camera.jpg";
import "./LoginPage.css";
import Login from "./SignIn/Login";
import Register from "./SignUp/Register";

export default function LoginPage() {
  const [isLogin, setIsLogin] = useState(true);

  const changeisLogin = () => {
    if (isLogin) setIsLogin(false);
    else setIsLogin(true);
  };

  return (
    <div className="Login_Main">
      <Grid container>
        <Grid item xs={2}></Grid>

        <Grid item xs={8}>
          <div className="loginpage_main">
            {/*Image*/}
            <div className="image_text_conatiner">
              <img
                src={login_img}
                width="500px"
                style={{ borderRadius: "9px" }}
                alt=""
              ></img>
              <div className="time_to_travel">TIME TO TRAVEL</div>
            </div>

            {/*Login box*/}
            <div className="loginpage_rightComponent">
              {/*SignIn Div*/}
              <div className="loginpage_signin">
                {isLogin ? <Login /> : <Register />}
              </div>

              {/*SignIn/SignUp Option Div*/}
              <div>
                {isLogin ? (
                  <div className="loginpage_signin">
                    Don't have an account?{" "}
                    <span
                      onClick={changeisLogin}
                      style={{ fontWeight: "bold", color: "#0395F6" }}
                    >
                      Register
                    </span>
                  </div>
                ) : (
                  <div className="loginpage_signin">
                    Have an account?{" "}
                    <span
                      onClick={changeisLogin}
                      style={{ fontWeight: "bold", color: "#0395F6" }}
                    >
                      Log In
                    </span>
                  </div>
                )}
              </div>
            </div>
          </div>
        </Grid>

        <Grid item xs={2}></Grid>
      </Grid>
    </div>
  );
}

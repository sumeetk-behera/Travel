import React, { useState } from "react";
import { MdOutlineTravelExplore } from "react-icons/md";
import { AiFillCloseCircle } from "react-icons/ai";
import { TbGridDots } from "react-icons/tb";
import "../Navbar/Navbar.scss";

export default function Navbar() {
  //1.1st for navBar class will be there inside active--we gave this class to NAVBAR below
  const [active, setActive] = useState("navBar");

  //2.Function to toggle navBar
  const showNav = () => {
    //as activeNavbar is inside navBar so chaining class we r setting below
    setActive("navBar activeNavbar");
  };

  //4.Function to close/remove navbar after toggle
  //as it will set the NAVBAR div class to "navBar" again to vanish it after toggle
  const removeNav = () => {
    setActive("navBar");
  };

  return (
    <section className="navBarSection">
      <header className="header flex">
        {/*TRAVEL & LOGO*/}
        <div className="logoDiv">
          <a href="#" className="logo">
            <h1>
              {" "}
              <MdOutlineTravelExplore className="icon" /> Travel.
            </h1>
          </a>
        </div>

        {/*NAVBAR*/}
        <div className={active}>
          <ul className="navLists flex">
            <li className="navItem">
              <a href="#" className="navLink">
                Home
              </a>
            </li>

            <li className="navItem">
              <a href="#" className="navLink">
                Packages
              </a>
            </li>

            <li className="navItem">
              <a href="#" className="navLink">
                Shop
              </a>
            </li>

            <li className="navItem">
              <a href="#" className="navLink">
                About
              </a>
            </li>

            <li className="navItem">
              <a href="#" className="navLink">
                Pages
              </a>
            </li>

            <li className="navItem">
              <a href="#" className="navLink">
                News
              </a>
            </li>

            <li className="navItem">
              <a href="#" className="navLink">
                Contact
              </a>
            </li>

            <button className="btn">
              <a href="#">BOOK NOW</a>
            </button>
          </ul>

          <div className="closeNavbar" onClick={removeNav}>
            <AiFillCloseCircle className="icon" />
          </div>
        </div>

        {/*3. Adding onclick func to change the NAVBAR class from active to activeNavbar*/}
        <div className="toggleNavbar" onClick={showNav}>
          <TbGridDots className="icon" />
        </div>
      </header>
    </section>
  );
}

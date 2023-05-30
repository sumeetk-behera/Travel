import React, { useEffect } from "react";
import video1 from "../../Assets/video2.mp4";
//Scrolling animation
import Aos from "aos";
import "aos/dist/aos.css";

//icons
import { FiSend } from "react-icons/fi";
import { MdOutlineTravelExplore } from "react-icons/md";
import {
  AiOutlineTwitter,
  AiFillYoutube,
  AiFillInstagram,
} from "react-icons/ai";
import { FaTripadvisor } from "react-icons/fa";
import { FiChevronRight } from "react-icons/fi";

import "../Footer/Footer.scss";

export default function Footer() {
  //Add react hook to add a scroll animation..
  useEffect(() => {
    Aos.init({ duration: 2000 });
  }, []);

  return (
    <section className="footer">
      {/*Video*/}
      <div className="videoDiv">
        <video src={video1} loop autoPlay muted type="video/mp4"></video>
      </div>

      {/*Footer--secContent*/}
      <div className="secContent container">
        {/*secContent--contactDiv--Keep In touch--SendLogo*/}
        <div className="contactDiv flex">
          <div data-aos="fade-up" className="text">
            <small>KEEP IN TOUCH</small>
            <h2>Travel with us</h2>
          </div>

          <div className="inputDiv flex">
            <input data-aos="fade-up" type="text" placeholder="Enter Email" />
            <button data-aos="fade-up" className="btn flex" type="submit">
              SEND
              <FiSend className="icon" />
            </button>
          </div>
        </div>

        {/*secContent--FooterCard*/}
        <div className="footerCard flex">
          {/*FooterCard--Travel. To Social logos*/}
          <div className="footerIntro flex">
            <div className="logoDiv">
              <a href="#" className="logo flex">
                Travel.
                <MdOutlineTravelExplore className="icon" />
              </a>
            </div>

            <div data-aos="fade-up" className="footerParagraph">
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Nulla
              iste exercitationem rerum saepe ratione officia facere quas nobis
              quasi id?Lorem, ipsum dolor sit amet consectetur adipisicing elit.
              Velit repellendus optio repudiandae quis aperiam labore dolorem
              modi inventore debitis tempore, voluptatum temporibus sequi. Alias
              perferendis commodi delectus quaerat natus voluptatibus.
            </div>

            <div data-aos="fade-up" className="footerSocials">
              <AiOutlineTwitter className="icon" />
              <AiFillYoutube className="icon" />
              <AiFillInstagram className="icon" />
              <FaTripadvisor className="icon" />
            </div>
          </div>

          {/*FooterCard--OurAgency, Partners, LastMinutes Groups List*/}
          <div className="footerLinks grid">
            {/*GROUP ONE*/}
            <div
              data-aos="fade-up"
              data-aos-duration="3000"
              className="linkGroup"
            >
              <span className="groupTitle">OUR AGENCY</span>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                Services
              </li>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                Insaurance
              </li>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                Agency
              </li>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                Tourism
              </li>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                Payment
              </li>
            </div>

            {/*GROUP TWO*/}
            <div
              data-aos="fade-up"
              data-aos-duration="4000"
              className="linkGroup"
            >
              <span className="groupTitle">PARTNERS</span>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                Bookings
              </li>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                Rentcars
              </li>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                HostelWorld
              </li>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                Trivago
              </li>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                TripAdvisor
              </li>
            </div>

            {/*GROUP THREE*/}
            <div
              data-aos="fade-up"
              data-aos-duration="5000"
              className="linkGroup"
            >
              <span className="groupTitle">LAST MINUTE</span>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                London
              </li>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                California
              </li>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                Indonesia
              </li>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                Dubai
              </li>

              <li className="footerList flex">
                <FiChevronRight className="icon" />
                Ocenia
              </li>
            </div>
          </div>

          <div className="footerDiv flex">
            <small>BEST TRAVEL WEBSITE</small>
            <small>COPYRIGHTS RESERVED - SUMEET 2023</small>
          </div>
        </div>
      </div>
    </section>
  );
}

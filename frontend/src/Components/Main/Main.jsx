import React, { useEffect } from "react";
import "../Main/Main.scss";
//Scrolling animation
import Aos from "aos";
import "aos/dist/aos.css";

import { HiOutlineLocationMarker } from "react-icons/hi";
import { HiOutlineClipboardCheck } from "react-icons/hi";
import img1 from "../../Assets/img1.jpg";
import img2 from "../../Assets/img2.jpg";
import img3 from "../../Assets/img.jpg";
import img4 from "../../Assets/img4.jpg";
import img5 from "../../Assets/img5.jpg";
import img6 from "../../Assets/img6.jpg";
import img7 from "../../Assets/img7.jpg";
import img8 from "../../Assets/img8.jpg";

const data = [
  {
    id: 1,
    imgSrc: img1,
    desTitle: "Bora Bora",
    location: "New Zealand",
    grade: "CULTURAL RELAX",
    fees: "$700",
    description: `The Epitome of romance, Bora Bora island will make you feel love at first sight. 
      With ocean views  of turquoise waters resembling an artist’s palette of bright blues and greens, 
      romantics from around the world appreciate Bora Bora’s, lush, 
      tropical vegetation circling the perimeter of the island and the valleys of Mount 
      Otemanu blossom with hibiscus.`,
  },

  {
    id: 2,
    imgSrc: img2,
    desTitle: "Bora Bora",
    location: "New Zealand",
    grade: "CULTURAL RELAX",
    fees: "$700",
    description: `The Epitome of romance, Bora Bora island will make you feel love at first sight.
      With ocean views  of turquoise waters resembling an artist’s palette of bright blues and greens,
      romantics from around the world appreciate Bora Bora’s, lush,
      tropical vegetation circling the perimeter of the island and the valleys of Mount
      Otemanu blossom with hibiscus.`,
  },

  {
    id: 3,
    imgSrc: img3,
    desTitle: "Bora Bora",
    location: "New Zealand",
    grade: "CULTURAL RELAX",
    fees: "$700",
    description: `The Epitome of romance, Bora Bora island will make you feel love at first sight.
      With ocean views  of turquoise waters resembling an artist’s palette of bright blues and greens,
      romantics from around the world appreciate Bora Bora’s, lush,
      tropical vegetation circling the perimeter of the island and the valleys of Mount
      Otemanu blossom with hibiscus.`,
  },

  {
    id: 4,
    imgSrc: img4,
    desTitle: "Bora Bora",
    location: "New Zealand",
    grade: "CULTURAL RELAX",
    fees: "$700",
    description: `The Epitome of romance, Bora Bora island will make you feel love at first sight.
      With ocean views  of turquoise waters resembling an artist’s palette of bright blues and greens,
      romantics from around the world appreciate Bora Bora’s, lush,
      tropical vegetation circling the perimeter of the island and the valleys of Mount
      Otemanu blossom with hibiscus.`,
  },

  {
    id: 5,
    imgSrc: img5,
    desTitle: "Bora Bora",
    location: "New Zealand",
    grade: "CULTURAL RELAX",
    fees: "$700",
    description: `The Epitome of romance, Bora Bora island will make you feel love at first sight.
      With ocean views  of turquoise waters resembling an artist’s palette of bright blues and greens,
      romantics from around the world appreciate Bora Bora’s, lush,
      tropical vegetation circling the perimeter of the island and the valleys of Mount
      Otemanu blossom with hibiscus.`,
  },

  {
    id: 6,
    imgSrc: img6,
    desTitle: "Bora Bora",
    location: "New Zealand",
    grade: "CULTURAL RELAX",
    fees: "$700",
    description: `The Epitome of romance, Bora Bora island will make you feel love at first sight.
      With ocean views  of turquoise waters resembling an artist’s palette of bright blues and greens,
      romantics from around the world appreciate Bora Bora’s, lush,
      tropical vegetation circling the perimeter of the island and the valleys of Mount
      Otemanu blossom with hibiscus.`,
  },
  {
    id: 7,
    imgSrc: img7,
    desTitle: "Bora Bora",
    location: "New Zealand",
    grade: "CULTURAL RELAX",
    fees: "$700",
    description: `The Epitome of romance, Bora Bora island will make you feel love at first sight.
      With ocean views  of turquoise waters resembling an artist’s palette of bright blues and greens,
      romantics from around the world appreciate Bora Bora’s, lush,
      tropical vegetation circling the perimeter of the island and the valleys of Mount
      Otemanu blossom with hibiscus.`,
  },
  {
    id: 8,
    imgSrc: img8,
    desTitle: "Bora Bora",
    location: "New Zealand",
    grade: "CULTURAL RELAX",
    fees: "$700",
    description: `The Epitome of romance, Bora Bora island will make you feel love at first sight.
      With ocean views  of turquoise waters resembling an artist’s palette of bright blues and greens,
      romantics from around the world appreciate Bora Bora’s, lush,
      tropical vegetation circling the perimeter of the island and the valleys of Mount
      Otemanu blossom with hibiscus.`,
  },
  {
    id: 9,
    imgSrc: img3,
    desTitle: "Bora Bora",
    location: "New Zealand",
    grade: "CULTURAL RELAX",
    fees: "$700",
    description: `The Epitome of romance, Bora Bora island will make you feel love at first sight.
      With ocean views  of turquoise waters resembling an artist’s palette of bright blues and greens,
      romantics from around the world appreciate Bora Bora’s, lush,
      tropical vegetation circling the perimeter of the island and the valleys of Mount
      Otemanu blossom with hibiscus.`,
  },
];

export default function Main() {
  //Add react hook to add a scroll animation..
  useEffect(() => {
    Aos.init({ duration: 2000 });
  }, []);

  return (
    <section className="main container section">
      <div className="secTitle">
        <h3 data-aos="fade-right" className="title">
          Most visited destinations
        </h3>
      </div>

      <div className="secContent grid">
        {data.map(
          ({ id, imgSrc, desTitle, location, grade, fees, description }) => {
            return (
              <div data-aos="fade-up" key={id} className="singleDestination">
                <div className="imgDiv">
                  <img src={imgSrc} alt={desTitle} />
                </div>

                <div className="cardInfo">
                  <h4 className="destTitle">{desTitle}</h4>
                  <span className="continent flex">
                    <HiOutlineLocationMarker className="icon" />
                    <span className="name">{location}</span>
                  </span>

                  <div className="fees flex">
                    <div className="grade">
                      <span>
                        {grade}
                        <small>+1</small>
                      </span>
                    </div>
                    <div className="price"></div>
                    <h5>{fees}</h5>
                  </div>

                  <div className="desc">
                    <p>{description}</p>
                  </div>

                  <button className="btn flex">
                    DETAILS <HiOutlineClipboardCheck className="icon" />
                  </button>
                </div>
              </div>
            );
          }
        )}
      </div>
    </section>
  );
}

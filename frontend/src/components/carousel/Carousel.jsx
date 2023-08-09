import React from "react";
import AliceCarousel from "react-alice-carousel";
import "react-alice-carousel/lib/alice-carousel.css";
import { carouselData } from "../../data/carouselData";

const Carousel = () => {
  const items = carouselData.map((item) => (
    <img
      className="cursor-pointer"
      role="presentation"
      src={item.image}
      alt=""
    ></img>
  ));
  return (
    <AliceCarousel
      items={items}
      disableButtonsControls
      autoPlay
      autoPlayInterval={3000}
      infinite
    />
  );
};
export default Carousel;

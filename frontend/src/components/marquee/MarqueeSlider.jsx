import React from "react";
import Marquee from "react-fast-marquee";
import { marquee } from "../../data/marquee";

const MarqueeSlider = () => {
  return (
    <div>
      <Marquee play speed={100} direction="right" gradient loop={0}>
        {marquee.map((img, i) => (
          <img key={i} style={{ height: "200px" }} src={img.imgUrl} alt="" />
        ))}
      </Marquee>
    </div>
  );
};

export default MarqueeSlider;

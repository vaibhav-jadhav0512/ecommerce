import React from "react";
import AliceCarousel from "react-alice-carousel";
import Testimonial from "./Testimonial";
import { testimonial } from "../../data/testimonials";
const TestimonialCarousal = () => {
  const items = testimonial.map((item) => <Testimonial testimony={item} />);
  return (
    <div className="relative p-5">
      <AliceCarousel
        items={items}
        disableButtonsControls
        autoPlay
        autoPlayInterval={2000}
        infinite
      />
    </div>
  );
};

export default TestimonialCarousal;

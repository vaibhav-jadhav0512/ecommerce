import React from "react";
import { Swiper, SwiperSlide } from "swiper/react";

import "swiper/css";
import "swiper/css/effect-coverflow";
import "swiper/css/pagination";
import "swiper/css/navigation";
import "./swpier.css";

import { EffectCoverflow, Pagination, Navigation } from "swiper";
import { testimonial } from "../../data/testimonials";
import Slider from "../slider/Slider";

function SwiperComponent() {
  return (
    <div className="container container-testimonial relative p-5">
      <div className="font-Poppins bg-white text-gray-700">
        <div className="text-center">
          <h1 className="text-4xl w-96 mx-auto leading-normal font-bold mb-12">
            Testimonials
          </h1>
          <Swiper
            effect={"coverflow"}
            grabCursor={true}
            centeredSlides={true}
            loop={true}
            slidesPerView={"auto"}
            coverflowEffect={{
              rotate: 0,
              stretch: 0,
              depth: 100,
              modifier: 2.5,
            }}
            pagination={{ el: ".swiper-pagination", clickable: true }}
            navigation={{
              nextEl: ".swiper-button-next",
              prevEl: ".swiper-button-prev",
              clickable: true,
            }}
            modules={[EffectCoverflow, Pagination, Navigation]}
            className="swiper_container"
          >
            {testimonial.map((item, i) => (
              <SwiperSlide key={i}>
                <Slider testim={item} />
              </SwiperSlide>
            ))}
          </Swiper>
        </div>
      </div>
    </div>
  );
}

export default SwiperComponent;

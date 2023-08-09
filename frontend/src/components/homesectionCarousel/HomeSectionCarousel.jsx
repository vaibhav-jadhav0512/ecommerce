import React, { useState } from "react";
import AliceCarousel from "react-alice-carousel";
import HomeSectionCard from "../homesectionCard/HomeSectionCard";
import { Button } from "@mui/material";
import { KeyboardArrowLeft } from "@mui/icons-material";

const HomeSectionCarousel = ({ data, sectionName }) => {
  const [activeIndex, setActiveIndex] = useState(0);

  const responsive = {
    0: { items: 2 },
    720: { items: 3 },
    1024: { items: 6.5 },
  };
  const slidePrev = () => {
    setActiveIndex(activeIndex - 1);
  };
  const slideNext = () => {
    setActiveIndex(activeIndex + 1);
  };
  const syncActiveIndex = (item) => setActiveIndex(item);
  const items = data.map((item) => <HomeSectionCard product={item} />);
  return (
    <div>
      <h2 className="text-2xl font-extrabold text-gray-800 py-5">
        {sectionName}
      </h2>
      <div className="relative p-5">
        <AliceCarousel
          items={items}
          responsive={responsive}
          disableButtonsControls
          disableDotsControls
          onSlideChange={syncActiveIndex}
          activeIndex={activeIndex}
        />
        {activeIndex !== items.length - 5 && (
          <Button
            className="z-50"
            variant="contained"
            onClick={slideNext}
            sx={{
              position: "absolute",
              top: "8rem",
              right: "0rem",
              transform: "translateX(50%) rotate(90deg)",
              bgcolor: "white",
            }}
            aria-label="next"
          >
            <KeyboardArrowLeft
              sx={{ transform: "rotate(90deg)", color: "black" }}
            />
          </Button>
        )}
        {activeIndex !== 0 && (
          <Button
            className="z-50"
            variant="contained"
            onClick={slidePrev}
            sx={{
              position: "absolute",
              top: "8rem",
              left: "0rem",
              transform: "translateX(-50%) rotate(90deg)",
              bgcolor: "white",
            }}
            aria-label="prev"
          >
            <KeyboardArrowLeft
              sx={{ transform: "rotate(-90deg)", color: "black" }}
            />
          </Button>
        )}
      </div>
    </div>
  );
};

export default HomeSectionCarousel;

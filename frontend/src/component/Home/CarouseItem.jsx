// CarouselItem.js
import React from 'react';
import "./food.jpg"

const CarouselItem = ({ image, title }) => {
    return (
        <div className='flex flex-col justify-center items-center'>
            <img
                className='w-[10rem] h-[10rem] lg:h-[14rem] lg:w-[14rem] rounded-full object-cover object-center'
                src={image}
               
            />
            <span className='py-5 font-semibold text-xl text-gray-400'>{title}</span>
            {console.log(image)
            }
        </div>
    );
}

export default CarouselItem;

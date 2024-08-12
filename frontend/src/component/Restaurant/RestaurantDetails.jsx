import { Divider, FormControl, FormControlLabel, Grid, Radio, RadioGroup, Typography } from '@mui/material'
import React, { useState } from 'react'
import LocationOnIcon from '@mui/icons-material/LocationOn';
import CalendarTodayIcon from '@mui/icons-material/CalendarToday';
import MenuCard from './MenuCard';


const categories = [
  "pizza",
  "biriyani",
  "burger",
  "rotti",
  "kottu",
  "rice"
]

const foodtypes =[
  {label:"All" , value:"all"},
  {label:"Vegetarian only" , value:"vegetarian"},
  {label:"Non-Vegetarian" , value:"non_vegetarian"},
  {label:"Seasonal" , value:"seasonal"},
];

const menu = [1,1,1,1,1,1,1,1,1];



const RestaurantDetails = () => {

    const [foodType , setFoodType ]  = useState("all");

    const handleFilter =(e)=>{
        console.log(e.target.value, e.target.name);
        
    }

  return (
    <div className='px-5 lg:px-20' >
      
      <section>
        <h3 className='text-gray-500 py-2 mt-10' >Home/india/indian fast food/3</h3>
        <div>
          <Grid container spacing={2} >
            <Grid item xs={12} >

              <img className='w-full h-[40vh] object-cover' src='https://assets.bonappetit.com/photos/610aa6ddc50e2f9f7c42f7f8/master/pass/Savage-2019-top-50-busy-restaurant.jpg' />

            </Grid>
            <Grid item xs={12} lg={6} >

                <img className='w-full h-[40vh] object-cover' src='https://t3.ftcdn.net/jpg/03/24/73/92/360_F_324739203_keeq8udvv0P2h1MLYJ0GLSlTBagoXS48.jpg' />

            </Grid>
            <Grid item xs={12} lg={6} >

                <img className='w-full h-[40vh] object-cover' src='https://images.pexels.com/photos/262978/pexels-photo-262978.jpeg' />

            </Grid>
          </Grid>
        </div>
        <div className='pt-3 pb-5' >
            <h1 className='text-4xl font-semibold' >Sri Lankan Fast Food</h1>

            <p className='text-gray-500 mt-1' >Lorem ipsum dolor sit amet consectetur adipisicing elit. 
              Perferendis illo magnam tenetur corporis nesciunt a velit reprehenderit maiores optio ducimus repellat est odit,
               consequatur qui nam fugit quidem. Tempora, qui.
            </p>

             <div className='space-y-3 mt-3' >
             <p className='text-gray-500 flex items-center gap-3' >
              <LocationOnIcon/>
              <span>
                Homagama, Colombo.
              </span> 
            </p>
            <p className='text-gray-500 flex items-center gap-3' >
              <CalendarTodayIcon/>
              <span>
                Mon-Sun: 9:00 AM - 9:00 PM (Today)
              </span> 
            </p>
             </div>
        </div>
      </section>
      <Divider/>

      <section className='pt-[2rem] lg:flex relative' >
        <div className='space-y-10 lg:w-[20%] filter ' >
          
            <div className='box space-y-5 lg:sticky top-28' >
                <div>
                  <Typography variant='h5' sx={{paddingBottom:"1rem"}} >Food Type</Typography>

                  <FormControl  className='py-10 space-y-5' component={'fieldset'} >
                    <RadioGroup onChange={handleFilter} name='food_type' value={foodType } >
                      {foodtypes.map((item, index) => <FormControlLabel key={index} value={item.value} control={<Radio/>} label={item.label} />)}
                    </RadioGroup>
                  </FormControl>


                </div>
                <Divider/>
                <div>
                  <Typography variant='h5' sx={{paddingBottom:"1rem"}} >Food Category</Typography>

                  <FormControl  className='py-10 space-y-5' component={'fieldset'} >
                    <RadioGroup onChange={handleFilter} name='food_type' value={foodType } >
                      {categories.map((item, index) => <FormControlLabel key={index} value={item} control={<Radio/>} label={item} />)}
                    </RadioGroup>
                  </FormControl>


                </div>
            </div>


        </div>
        <div className='space-y-5 lg:w-[80%] lg:pl-10' >
          {menu.map((item , index)=> <MenuCard/>)}
        </div>
      </section>


    </div>
  )
}

export default RestaurantDetails

import React from 'react'

import Accordion from '@mui/material/Accordion';
import AccordionSummary from '@mui/material/AccordionSummary';
import AccordionDetails from '@mui/material/AccordionDetails';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import { Button } from '@mui/material';

const ingredient = [
  {
    category: "Nuts & Seeds",
    ingredients:["Cashews"]
  },
  {
    category:"potein",
    ingredients:["Ground beef", "Bacon strips"]
  },
  {
    category: "bread",
    ingredients:["Cashews"]
  },
  {
    category: "vegetable",
    ingredients:["Lettuce","Tomato slices","Pickles", "Onion slices"]
  },
  {
    category: "Condiment",
    ingredients:["Ketchup"]
  },
]




const MenuCard = () => {

  const handleCheckBoxChange = (value)=>{
      console.log("value");
      
  }


  return (
    <div>
      <Accordion>
        <AccordionSummary
          expandIcon={<ExpandMoreIcon />}
          aria-controls="panel1-content"
          id="panel1-header"
        >
          <div className='lg:flex items-center justify-between' >
              <div className='lg:flex items-center lg:gap-5' >
                <img  className='w-[7rem] h-[7rem] object-cover' src='https://images.pexels.com/photos/376464/pexels-photo-376464.jpeg?cs=srgb&dl=pexels-ash-craig-122861-376464.jpg&fm=jpg' alt='' />
                <div className='space-y-1 lg:space-y-5 lg:max-w-2xl' >
                  <p className='font-semibold text-xl' >Burger</p>
                  <p>Rs:499</p>
                  <p  className='text-gray-400' >nice Food</p>
                </div>
              </div>
          </div>
        </AccordionSummary>
        <AccordionDetails>
          <form>
            <div className='flex gap-5 flex-wrap' >
            {
                ingredient.map((item, index) => (
                  <div key={index}>
                    <p>{item.category}</p>
                    <FormGroup>
                      {item.ingredients.map((ingredient, idx) => (
                        <FormControlLabel
                          onChange={ ()=> handleCheckBoxChange(item)}
                          key={idx}
                          control={<Checkbox />}
                          label={ingredient}
                        />
                      ))}
                    </FormGroup>
                  </div>
                ))
              }
            </div>
            <div className='pt-5' >
              <Button variant='contained' disabled={false} type='submit'  >{true? "Add to Cart": "Out of Stack"}</Button>
            </div>
          </form>
        </AccordionDetails>
      </Accordion>
    </div>
  )
}

export default MenuCard
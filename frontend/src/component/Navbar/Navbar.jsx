import React from 'react'
import SearchIcon from '@mui/icons-material/Search';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import { Avatar, Badge, Box, IconButton } from '@mui/material';
import { pink } from '@mui/material/colors';
import "./Navbar.css";

const Navbar = () => {
  return (
    <Box className='px-5 sticky top-0  z-50 py-[.8rem] bg-[#e91e63] 1g:px-20 flex justify-between' >
      <div className='flex items-center space-x-4'>
        <div className='lg:mr-10 cursor-pointer flex items-center space-x-4' >
            <li className='logo font-semibold text-gray-300 text-2xl' >
                Zosh food
            </li>
        </div>
       
      </div>
      <div className='flex items-center space-x-2 lg:space-x-10' >
        <div className=''>
        <IconButton>
            <SearchIcon SX={{fontSize: "1.5rem"}} />
        </IconButton>
        </div>
        <div className='' >

        <IconButton>
            <Avatar sx={{bgcolor:"white", color:pink.A400}} >C</Avatar>
        </IconButton>
        
      </div>
      <div className='' >

        <IconButton>
          <Badge color='secondary' badgeContent={3} >
             <ShoppingCartIcon SX={{fontSize: "1.5rem"}} />
          </Badge>
           
        </IconButton>

      </div>
        
      </div>
      
      
    </Box>
  )
}

export default Navbar

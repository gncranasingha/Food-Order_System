import React from 'react'
import ShoppingBagIcon from '@mui/icons-material/ShoppingBag';
import FavoriteIcon from '@mui/icons-material/Favorite';
import HomeIcon from '@mui/icons-material/Home';
import PaymentIcon from '@mui/icons-material/Payment';
import NotificationsIcon from '@mui/icons-material/Notifications';
import EventIcon from '@mui/icons-material/Event';
import LogoutIcon from '@mui/icons-material/Logout';
import { Divider, Drawer, useMediaQuery } from '@mui/material';
import { useNavigate } from 'react-router-dom';


const menu =[
    {title:"Orders" , icon:<ShoppingBagIcon/>},
    {title:"Favorites" , icon:<FavoriteIcon/>},
    {title:"Address" , icon:<HomeIcon/>},
    {title:"Payments" , icon:<PaymentIcon/>},
    {title:"Notification" , icon:<NotificationsIcon/>},
    {title:"Events" , icon:<EventIcon/>},
    {title:"Logout" , icon:<LogoutIcon/>}
    
]

const ProfileNavigation = ({open,handleClose}) => {

const isSmallScreen = useMediaQuery("(max-width:900)")

const navigate = useNavigate();

const handleNavigate = (item)=>{
  navigate(`/my-profile/${item.title.toLowerCase()}`)
}

  return (
    <div>
        <Drawer 
            variant={isSmallScreen? "temporary" : "permanent"} 
            onClose={handleClose} 
            open={isSmallScreen ? open : true} 
            anchor='left'  
            sx={{zIndex:-1, position:"sticky"}} >
                <div className='w-[50vw] lg:w-[20vw] h-[100vh] flex flex-col justify-center  text-xl gap-8 pt-16' >
                    {menu.map((item, index)=><>
                        <div  onClick={()=>handleNavigate(item)} key={index} className='px-5 flex items-center space-x-5 cursor-pointer' >
                            {item.icon}
                            <span>{item.title}</span>
                        </div>
                        {index!== menu.length-1 && <Divider/>}
                  </>  )}
                </div>
            </Drawer>
    </div>
  )
}

export default ProfileNavigation
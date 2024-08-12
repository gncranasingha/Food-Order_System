import { Button, Card } from '@mui/material'
import React from 'react'

const OrderCard = () => {
  return (
    <Card className="flex justify-between items-center p-5" >
        <div className='flex items-center space-x-5' >
            <img className='h-16 w-16' src='https://img.freepik.com/free-photo/top-view-pepperoni-pizza-with-mushroom-sausages-bell-pepper-olive-corn-black-wooden_141793-2158.jpg'  alt='' />
            <div>
                <p>Biryani</p>
                <p>$399</p>
            </div>
        </div>
        <div>
            <Button className='cursor-not-allowed' >Completed</Button>
        </div>
    </Card>
  )
}

export default OrderCard
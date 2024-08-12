import { Style } from '@mui/icons-material';
import { Modal } from '@mui/material'
import React from 'react'
import { useLocation, useNavigate } from 'react-router-dom'
import { style } from '../Cart/Cart';

const Auth = () => {

    const location = useLocation();
    const navigate = useNavigate();

  return (
    <>
        <Modal open={
            location.pathname === "/account/register"
            || location.pathname === "account/login"
        } >

            <Box sx={{style}} ></Box>

        </Modal>
    </>
  )
}

export default Auth
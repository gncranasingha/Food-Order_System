
import './App.css';
import Cart from './component/Cart/Cart';
import Home from './component/Home/Home';
import Navbar from './component/Navbar/Navbar';
import Profile from './component/profile/Profile';
import RestaurantDetails from './component/Restaurant/RestaurantDetails';
import CustomerRoute from './Routers/CustomerRoute';
import { darkTheme } from './Theme/DarkTheme';
import { CssBaseline,ThemeProvider  } from '@mui/material';

function App() {
  return (
    <ThemeProvider theme={darkTheme} >
      <CssBaseline/>
      {/* <Navbar/> */}
      {/* <Home/> */}
      {/* <RestaurantDetails/> */}
      {/* <Cart/> */}
      {/* <Profile/> */}
      <CustomerRoute/>
    </ThemeProvider>
  );
}

export default App;

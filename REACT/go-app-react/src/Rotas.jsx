import React from 'react';
import { Route, Routes, BrowserRouter } from 'react-router-dom';

//imports das páginas
import Index from './pages/Index';
import DashboardComplaint from './pages/DashboardComplaint';
import DashboardAdmin from './pages/DashboardAdmin';
import DashboardProfile from './pages/DashboardProfile';
import DashboardUser from './pages/DashboardUser';
import DashboardLogin from './pages/DashboardLogin';

const Rotas = () => {
    return (
        <BrowserRouter>
            <Routes>
            <Route path="/" element={<Index />} />
            <Route path='/complaint' element={<DashboardComplaint />} />
            <Route path="/login" element={<DashboardLogin />} />
                <Route path="/admin" element={<DashboardAdmin />} />
                {/*pagina não encontrada:*/}
                {/* <Route path="*" element={<NotFound />} /> */}
                <Route path="/profile" element={<DashboardProfile />} />
                <Route path="/user" element={<DashboardUser />} />
            </Routes>
        </BrowserRouter>
    )
}

export default Rotas;
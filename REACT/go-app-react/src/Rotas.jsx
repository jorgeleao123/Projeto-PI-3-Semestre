import React from 'react';
import { Route, Routes, BrowserRouter } from 'react-router-dom';

//imports das páginas
import DashboardAdmin from './pages/DashboardAdmin';
import DashboardProfile from './pages/DashboardProfile';

const Rotas = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<DashboardAdmin />} />
                {/*pagina não encontrada:*/}
                {/* <Route path="*" element={<NotFound />} /> */}

                <Route path="/profile" element={<DashboardProfile />} />
            </Routes>
        </BrowserRouter>
    )
}

export default Rotas;
import React from 'react';
import { Route, BrowserRoute } from 'react-router-dom';

//imports das páginas
import DashboardAdmin from './pages/DashboardAdmin';

const Routes = () => {
    return(
        <BrowserRoute>
            <Route path="/" element={<DashboardAdmin />} />
            {/*pagina não encontrada:*/}
            <Route path="*" element={<NotFound />} />
        </BrowserRoute>
    )
}

export default Rotas;
import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import './css/index.css';
import Login from './containers/Login';
import SignUp from './components/SignUp';
import * as serviceWorker from './serviceWorker';
import {storeGlob} from './storeConf';
import {Provider} from 'react-redux';
import Profile from './containers/Profile'

const App = () => (
    <Switch>
        <Route path='/login' component={Login}/>
        <Route path='/reg' component={SignUp}/>
        <Route path='/profile' component={Profile}/>
    </Switch>
);

ReactDOM.render(
    <Provider store={storeGlob}>
        <Router>
            <App/>
        </Router>
    </Provider>
    , document.getElementById('root'));

serviceWorker.unregister();

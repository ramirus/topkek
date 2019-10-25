import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import './index.css';
import Login from './Login';
import Chat from './Chat';
import * as serviceWorker from './serviceWorker';

const Test = () => (
    <Switch>
        <Route exact path='/login' component={Login}/>
        <Route path='/chat/:user' component={Chat}/>
    </Switch>
);
ReactDOM.render(<Router><Test/></Router>, document.getElementById('root'));

serviceWorker.unregister();

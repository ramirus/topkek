import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import * as serviceWorker from './serviceWorker';
import start from './start';
import v2 from './v2';
import v3 from './v3';

const Test = () => (
    <Switch>
        <Route exact path='/' component={start}/>
        <Route exact path='/v2' component={v2}/>
        <Route exact path='/v3' component={v3}/>
    </Switch>
);

ReactDOM.render(
        <Router>
            <Test/>
        </Router>
    ,document.getElementById('root'));
// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();

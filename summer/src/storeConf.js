import {applyMiddleware, createStore} from "redux";
import { reducer} from "./reducers/Red"
import {composeWithDevTools} from 'redux-devtools-extension';
import thunk from 'redux-thunk';

export const storeGlob = createStore(reducer,  composeWithDevTools(applyMiddleware(thunk)));


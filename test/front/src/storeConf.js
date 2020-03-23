import {createStore} from "redux";
import {chatState, reducer} from "./reducers/ChatRed"
import { composeWithDevTools } from 'redux-devtools-extension';

export const storeGlob = createStore(reducer, chatState, composeWithDevTools());


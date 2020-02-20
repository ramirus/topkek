import {createStore} from "redux";
import {chatState, reducer} from "./reducers/ChatRed"

export const storeGlob = createStore(reducer, chatState);


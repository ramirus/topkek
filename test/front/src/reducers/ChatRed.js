export const chatState = {
    messages: "",
    activeUsers: "sdfsdsdg"
};

export function reducer(state = chatState, action) {
    switch (action.type) {
        case 'UPDATE_MESS':
            return {
                ...state, messages: action.payload
            };
        default: {
            return state;
        }
    }
}
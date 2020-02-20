const UPDATE_MESS = "UPDATE_MESS";

export function updateMessages(messages) {
    return {
        type: UPDATE_MESS,
        payload: messages
    }
}
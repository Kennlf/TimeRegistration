export function setStatusMsg(msg, isError){
    const color = isError ? "red" : "yellow"
    const statusNode = document.getElementById("status")
    statusNode.style.color = color
    statusNode.innerText = msg
}
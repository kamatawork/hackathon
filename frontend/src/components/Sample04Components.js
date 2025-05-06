import React, { useState } from "react";
import axios from "axios";

const Sample04Components = () => {

const [text, setText] = useState("");  // テキストボックスの状態を保持する
  const [responseMessage, setResponseMessage] = useState("");  // サーバーからのレスポンスを表示するための状態

  // 決定ボタンを押したときにデータを送信する関数
  const handleSubmit = async () => {
    alert("押した");
    console.log("111122");
      try {
      // サーバーに送信する JSON データの作成
      alert("1");
      const data = { text: text };
      //text = "?number=77777777&name=鎌田敦";
      alert("2");
      // Axios で POST リクエストを送信
      const response = await axios.post("http://localhost:8080/api-04/add-user?number=77777777&name=鎌田敦", data, {
        headers: {
          "Content-Type": "application/json"
        }
      });
      alert("3");
      // レスポンスメッセージを状態に保存
      setResponseMessage(response.data);
      alert("4");
    } catch (error) {
      alert("9:" + error);
      console.error("Error sending data:", error);
      setResponseMessage("Error sending data");
    }
  };

  return (
    <div>
      <h1>Data Sender</h1>
      <input
        type="text"
        value={text}
        onChange={(e) => setText(e.target.value)}
        placeholder="Enter text here"
      />
      <button onClick={handleSubmit}>決定</button>
      
      {/* サーバーからのレスポンスを表示 */}
      {responseMessage && <p>{responseMessage}</p>}
    </div>
  );
};

export default Sample04Components;

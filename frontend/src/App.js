import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [userId, setUserId] = useState('');
  const [password, setPassword] = useState('');
  const [token, setToken] = useState(null);

  const handleLogin = async () => {
    try {
      const response = await axios.post('http://localhost:8080/auth/login', {
        userId,
        password,
      });
      setToken(response.data.token);

    } catch (error) {
      alert('ログイン失敗！:' + error);
    }
  };

  return (
    <div>
      {!token ? (
        <div>
          <h2>ログイン</h2>
          <input
            type="text"
            placeholder="ユーザーID"
            value={userId}
            onChange={(e) => setUserId(e.target.value)}
          />
          <input
            type="password"
            placeholder="パスワード"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <button onClick={handleLogin}>ログイン</button>
        </div>
      ) : (
        <div>
          <h2>メニュー</h2>
          <p>ログイン成功！メニュー画面を表示します。</p>
        </div>
      )}
    </div>
  );
}

export default App;

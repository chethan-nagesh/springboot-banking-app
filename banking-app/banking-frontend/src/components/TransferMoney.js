import { useState } from "react";
import { transactionApi } from "../api/api";

function TransferMoney() {
  const [form, setForm] = useState({
    fromAccountId: "",
    toAccountId: "",
    amount: "",
  });

  const [message, setMessage] = useState("");
  const [error, setError] = useState("");

  const handleChange = (e) =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const submit = async () => {
    try {
      setError("");
      setMessage("");
      await transactionApi.post("/transfer", form);
      setMessage("Transfer successful ✅");
    } catch (err) {
      setError(err.response?.data?.message || "Transaction failed");
    }
  };

  return (
    <div>
      <input
        className="input"
        name="fromAccountId"
        placeholder="From Account ID"
        onChange={handleChange}
      />
      <input
        className="input"
        name="toAccountId"
        placeholder="To Account ID"
        onChange={handleChange}
      />
      <input
        className="input"
        name="amount"
        placeholder="Amount"
        onChange={handleChange}
      />

      <button className="btn-primary" onClick={submit}>
        Transfer Money
      </button>

      {message && (
        <p className="mt-3 text-green-400 text-sm">{message}</p>
      )}
      {error && (
        <p className="mt-3 text-red-400 text-sm">{error}</p>
      )}
    </div>
  );
}

export default TransferMoney;

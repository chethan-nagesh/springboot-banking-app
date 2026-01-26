import { useState } from "react";
import { accountApi } from "../api/api";

function CreateAccount() {
  const [form, setForm] = useState({
    customerId: "",
    accountType: "SAVINGS",
    balance: "",
  });

  const handleChange = (e) =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const submit = async () => {
    await accountApi.post("", form);
    alert("Account created successfully");
  };

  return (
    <div>
      <input
        className="input"
        name="customerId"
        placeholder="Customer ID"
        onChange={handleChange}
      />

      <select
        className="input"
        name="accountType"
        onChange={handleChange}
      >
        <option>SAVINGS</option>
        <option>CURRENT</option>
      </select>

      <input
        className="input"
        name="balance"
        placeholder="Initial Balance"
        onChange={handleChange}
      />

      <button className="btn-primary" onClick={submit}>
        Create Account
      </button>
    </div>
  );
}

export default CreateAccount;

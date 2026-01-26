import { useState } from "react";
import { accountApi } from "../api/api";

function AccountList() {
  const [customerId, setCustomerId] = useState("");
  const [accounts, setAccounts] = useState([]);

  const fetchAccounts = async () => {
    const res = await accountApi.get(`/customer/${customerId}`);
    setAccounts(res.data);
  };

  return (
    <div>
      <input
        className="input"
        placeholder="Customer ID"
        onChange={(e) => setCustomerId(e.target.value)}
      />

      <button className="btn-secondary mb-4" onClick={fetchAccounts}>
        Fetch Accounts
      </button>

      <ul className="space-y-3">
        {accounts.map((acc) => (
          <li
            key={acc.id}
            className="flex justify-between items-center bg-slate-700 px-4 py-3 rounded-lg"
          >
            <div>
              <p className="font-semibold">{acc.accountType}</p>
              <p className="text-slate-400 text-sm">
                Account ID: {acc.id}
              </p>
            </div>

            <p className="text-lg font-bold text-green-400">
              ₹ {acc.balance}
            </p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default AccountList;

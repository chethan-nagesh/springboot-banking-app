import { useState } from "react";
import { customerApi } from "../api/api";

function CreateCustomer() {
  const [form, setForm] = useState({ fullName: "", email: "", phone: "" });
  const [customer, setCustomer] = useState(null);

  const handleChange = (e) =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const submit = async () => {
    const res = await customerApi.post("", form);
    setCustomer(res.data);
  };

  return (
    <div>
      <input
        className="input"
        name="fullName"
        placeholder="Full Name"
        onChange={handleChange}
      />
      <input
        className="input"
        name="email"
        placeholder="Email"
        onChange={handleChange}
      />
      <input
        className="input"
        name="phone"
        placeholder="Phone"
        onChange={handleChange}
      />

      <button className="btn-primary" onClick={submit}>
        Create Customer
      </button>

      {customer && (
        <p className="mt-3 text-green-400 text-sm">
          Customer ID: {customer.id}
        </p>
      )}
    </div>
  );
}

export default CreateCustomer;

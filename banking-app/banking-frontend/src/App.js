import Navbar from "./components/Navbar";
import CreateCustomer from "./components/CreateCustomer";
import CreateAccount from "./components/CreateAccount";
import AccountList from "./components/AccountList";
import TransferMoney from "./components/TransferMoney";

function App() {
  return (
    <div className="min-h-screen bg-slate-900 text-white">
      <Navbar />

      <div className="p-10">
        <h2 className="text-2xl font-semibold mb-8">
          Dashboard
        </h2>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
          <Card title="Create Customer">
            <CreateCustomer />
          </Card>

          <Card title="Create Account">
            <CreateAccount />
          </Card>

          <Card title="View Accounts">
            <AccountList />
          </Card>

          <Card title="Transfer Money">
            <TransferMoney />
          </Card>
        </div>
      </div>
    </div>
  );
}

function Card({ title, children }) {
  return (
    <div className="bg-slate-800 rounded-xl p-6 shadow-lg">
      <h3 className="text-lg font-semibold mb-4">{title}</h3>
      {children}
    </div>
  );
}

export default App;

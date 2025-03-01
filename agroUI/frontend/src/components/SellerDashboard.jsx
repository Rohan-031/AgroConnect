import { useState } from 'react';
import { Edit, Trash, Bell, BarChart2, Package, ShoppingBag, User, HelpCircle } from 'lucide-react';
import { useNavigate } from 'react-router-dom';
import Navbar from './Navbar';
import Footer from './Footer';
import AddProduct from './AddProduct';
export default function SellerDashboard() {
    const [products, setProducts] = useState([
        { id: 1, name: 'Fresh Tomatoes', price: '20/kg', stock: 50, image: 'https://via.placeholder.com/150' },
        { id: 2, name: 'Potatoes', price: '30/kg', stock: 100, image: 'https://via.placeholder.com/150' },
    ]);

    const navigate = useNavigate();

    const deleteProduct = (id) => {
        setProducts(products.filter((product) => product.id !== id));
    };

    return (
        <>
            <header className="bg-green-600 text-white py-4">
                <h1 className="text-3xl text-center font-bold">Welcome to AgroConnect</h1>
            </header>
            <div className="min-h-screen bg-gray-100 flex flex-col">

                <div className="p-6 grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
                    <div className="bg-white p-6 rounded-xl shadow-md flex flex-col items-center h-72">
                        <BarChart2 className="text-green-600 h-15 w-12 mb-4" />
                        <h2 className="text-xl font-bold mb-2">Sales Analytics</h2>
                        <p className="text-gray-500">View sales performance, top-selling products, and revenue insights.</p>
                    </div>
                    <div className="bg-white p-6 rounded-xl shadow-md flex flex-col items-center h-72">
                        <Package className="text-green-600 h-12 w-12 mb-4" />
                        <h2 className="text-xl font-bold mb-2">Product Management</h2>
                        <button onClick={() => navigate('/AddProduct')} className="bg-green-600 text-white py-2 px-4 rounded-md hover:bg-green-700 mt-4">
                            Add Product
                        </button>
                    </div>
                    <div className="bg-white p-6 rounded-xl shadow-md flex flex-col items-center h-72">
                        <ShoppingBag className="text-green-600 h-12 w-12 mb-4" />
                        <h2 className="text-xl font-bold mb-2">Order Management</h2>
                        <p className="text-gray-500">View and update order status to streamline operations.</p>
                    </div>
                    <div className="bg-white p-6 rounded-xl shadow-md flex flex-col items-center h-72">
                        <Bell className="text-green-600 h-12 w-12 mb-4" />
                        <h2 className="text-xl font-bold mb-2">Notifications & Alerts</h2>
                        <p className="text-gray-500">Stay updated with new orders and buyer messages.</p>
                    </div>
                    <div className="bg-white p-6 rounded-xl shadow-md flex flex-col items-center h-72">
                        <User className="text-green-600 h-12 w-12 mb-4" />
                        <h2 className="text-xl font-bold mb-2">Profile Management</h2>
                        <p className="text-gray-500">Update your information and contact details.</p>
                    </div>
                    <div className="bg-white p-6 rounded-xl shadow-md flex flex-col items-center h-72">
                        <HelpCircle className="text-green-600 h-12 w-12 mb-4" />
                        <h2 className="text-xl font-bold mb-2">Help & Support</h2>
                        <p className="text-gray-500">Access FAQs or contact support for assistance.</p>
                    </div>
                </div>
                <Footer />
            </div>
        </>
    );
}

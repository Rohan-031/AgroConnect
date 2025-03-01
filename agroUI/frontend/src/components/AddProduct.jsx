// import { useState } from 'react';
// import { Plus } from 'lucide-react';
// import Navbar from './Navbar';
// import Footer from './Footer';

// export default function AddProduct() {
//     const [products, setProducts] = useState([
//         {
//             id: 1,
//             name: 'Fresh Tomatoes',
//             price: '20/kg',
//             image: 'https://images.unsplash.com/photo-1601004890684-d8cbf643f5f2?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwzNjUyOXwwfDF8c2VhcmNofDF8fHRvbWF0b2VzfGVufDB8fHx8MTY5NTkxNTI5NQ&ixlib=rb-1.2.1&q=80&w=400',
//         },
//         {
//             id: 2,
//             name: 'Tomatos',
//             price: '30/kg',
//             image: 'https://images.unsplash.com/photo-1561136594-7f68413baa99?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8dG9tYXRvfGVufDB8fDB8fHww',
//         },
//         {
//             id: 3,
//             name: 'Leeches',
//             price: '30/kg',
//             image: 'https://media.istockphoto.com/id/1158995828/photo/litchi-chinensis-ripe-red-litchi-fruits-for-sale-by-the-roadside.jpg?s=2048x2048&w=is&k=20&c=QkApSFmSivx_6idEZeFdI2BHbqQg3gH4uNCbJBaC6Q4=',
//         }, {
//             id: 4,
//             name: 'Apples',
//             price: '30/kg',
//             image: 'https://images.unsplash.com/photo-1567306226416-28f0efdc88ce?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8YXBwbGVzfGVufDB8fDB8fHww',
//         },
//     ]);

//     const addProduct = () => {
//         const newProduct = {
//             id: products.length + 1,
//             name: 'New Product',
//             price: '00/kg',
//             image: 'https://via.placeholder.com/150',
//         };
//         setProducts([...products, newProduct]);
//     };

//     return (
//         <>
//             <header className="bg-green-600 text-white py-4">
//                 <h1 className="text-3xl text-center font-bold">Welcome to AgroConnect</h1>
//             </header>
//         <div className="min-h-screen bg-gradient-to-r from-green-50 to-green-100 flex flex-col">

//             <div className="p-6 flex flex-col items-center">
//                 <h1 className="text-3xl font-bold mb-6">Add New Products</h1>
//                 <button
//                     onClick={addProduct}
//                     className="flex items-center bg-green-600 text-white py-2 px-4 rounded-md hover:bg-green-700 shadow-md"
//                 >
//                     <Plus className="mr-2 h-5 w-5" /> Add Product
//                 </button>

//                 <div className="mt-8 grid grid-cols-1 gap-8 md:grid-cols-2 lg:grid-cols-3">
//                     {products.map((product) => (
//                         <div key={product.id} className="bg-white p-6 rounded-xl shadow-lg">
//                             <img src={product.image} alt={product.name} className="w-full h-40 object-cover rounded-lg mb-4" />
//                             <h2 className="text-xl font-semibold mb-2">{product.name}</h2>
//                             <p className="text-gray-700">Price: {product.price}</p>
//                         </div>
//                     ))}
//                 </div>
//             </div>

//             <Footer />
//         </div>
//         </>
//     );
// }

import { useState } from 'react';
import { Plus } from 'lucide-react';
import Navbar from './Navbar';
import Footer from './Footer';

export default function AddProduct() {
    const [products, setProducts] = useState([
        {
            id: 1,
            name: 'Fresh Tomatoes',
            price: '20/kg',
            quantity : 50,
            image: 'https://images.unsplash.com/photo-1601004890684-d8cbf643f5f2?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwzNjUyOXwwfDF8c2VhcmNofDF8fHRvbWF0b2VzfGVufDB8fHx8MTY5NTkxNTI5NQ&ixlib=rb-1.2.1&q=80&w=400',
        },
        {
            id: 2,
            name: 'Tomatos',
            price: '30/kg',
            image: 'https://images.unsplash.com/photo-1561136594-7f68413baa99?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8dG9tYXRvfGVufDB8fDB8fHww',
        }
    ]);

    const [showForm, setShowForm] = useState(false);
    const [newProduct, setNewProduct] = useState({ name: '', price: '',quantity:'', image: '' });

    const addProduct = () => {
        if (newProduct.name && newProduct.price && newProduct.image) {
            setProducts([...products, { ...newProduct, id: products.length + 1 }]);
            setNewProduct({ name: '', price: '', quantity: '',image: '' });
            setShowForm(false);
        }
    };

    return (
        <>
            <header className="bg-green-600 text-white py-4">
                <h1 className="text-3xl text-center font-bold">Welcome to AgroConnect</h1>
            </header>
            <div className="min-h-screen bg-gradient-to-r from-green-50 to-green-100 flex flex-col">

                <div className="p-6 flex flex-col items-center">
                    <h1 className="text-3xl font-bold mb-6">Add New Products</h1>
                    <button
                        onClick={() => setShowForm(true)}
                        className="flex items-center bg-green-600 text-white py-2 px-4 rounded-md hover:bg-green-700 shadow-md"
                    >
                        <Plus className="mr-2 h-5 w-5" /> Add Product
                    </button>

                    {showForm && (
                        <div className="mt-6 p-6 bg-white rounded-md shadow-md">
                            <h2 className="text-xl font-semibold mb-4">Enter Product Details</h2>
                            <input
                                type="text"
                                placeholder="Product Name"
                                value={newProduct.name}
                                onChange={(e) => setNewProduct({ ...newProduct, name: e.target.value })}
                                className="border p-2 mb-2 w-full rounded-md"
                            />
                            <input
                                type="text"
                                placeholder="Price (e.g., 20/kg)"
                                value={newProduct.price}
                                onChange={(e) => setNewProduct({ ...newProduct, price: e.target.value })}
                                className="border p-2 mb-2 w-full rounded-md"
                            />
                            <input
                                type="text"
                                placeholder="Image URL"
                                value={newProduct.image}
                                onChange={(e) => setNewProduct({ ...newProduct, image: e.target.value })}
                                className="border p-2 mb-2 w-full rounded-md"
                            />
                            <button
                                onClick={addProduct}
                                className="bg-green-600 text-white py-2 px-4 rounded-md mt-2"
                            >
                                Add Item
                            </button>
                        </div>
                    )}

                    <div className="mt-8 grid grid-cols-1 gap-8 md:grid-cols-2 lg:grid-cols-3">
                        {products.map((product) => (
                            <div key={product.id} className="bg-white p-6 rounded-xl shadow-lg">
                                <img src={product.image} alt={product.name} className="w-full h-40 object-cover rounded-lg mb-4" />
                                <h2 className="text-xl font-semibold mb-2">{product.name}</h2>
                                <p className="text-gray-700">Price: {product.price}</p>
                            </div>
                        ))}
                    </div>
                </div>

                <Footer />
            </div>
        </>
    );
}

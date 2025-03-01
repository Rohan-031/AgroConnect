import { useState } from 'react';
import { motion } from 'framer-motion';

export default function SignInPage() {
    const [userType, setUserType] = useState('farmer');
    const handleSwitch = (type) => setUserType(type);

    return (
        <div className="min-h-screen flex items-center justify-center  p-0 m-0">
            <div className="w-full max-w-md p-6 bg-white shadow-2xl rounded-2xl flex">
                <div className="flex-1 p-6">
                    <h2 className="text-3xl font-bold mb-4 text-center">Sign In</h2>
                    <div className="flex gap-4 mb-4">
                        <button
                            onClick={() => handleSwitch('farmer')}
                            className={`${userType === 'farmer' ? 'bg-green-600 text-white' : 'bg-gray-200'} px-4 py-2 rounded-full`}
                        >
                            Farmer
                        </button>
                        <button
                            onClick={() => handleSwitch('consumer')}
                            className={`${userType === 'consumer' ? 'bg-blue-600 text-white' : 'bg-gray-200'} px-4 py-2 rounded-full`}
                        >
                            Consumer
                        </button>
                    </div>
                    <motion.div
                        initial={{ opacity: 0, x: -50 }}
                        animate={{ opacity: 1, x: 0 }}
                        transition={{ duration: 0.5 }}
                        className="space-y-4"
                    >
                        <input type="text" placeholder="Phone Number" className="w-full p-2 border rounded" />
                        {userType === 'consumer' && (
                            <input type="email" placeholder="Email ID" className="w-full p-2 border rounded" />
                        )}
                        <input type="password" placeholder="Password" className="w-full p-2 border rounded" />
                        <button className="w-full bg-green-600 text-white p-2 rounded hover:bg-green-700 transition">
                            Sign In
                        </button>
                    </motion.div>
                </div>
            </div>
        </div>
    );
}

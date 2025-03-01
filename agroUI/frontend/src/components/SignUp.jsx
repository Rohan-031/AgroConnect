import { useState } from 'react';
import { motion } from 'framer-motion';
import { useNavigate } from 'react-router-dom';

export default function SignUp() {
    const [userType, setUserType] = useState('farmer');
    const handleSwitch = (type) => setUserType(type);
    const navigate = useNavigate();
    return (
        <div className="min-h-screen flex items-center justify-center  p-0 m-0">
            <div className="flex w-10/12 max-w-5xl bg-white rounded-3xl shadow-2xl overflow-hidden">
                {/* Left Side */}
                <div className="w-1/2 p-8 flex flex-col justify-center">
                    <h2 className="text-4xl font-bold mb-6 text-green-700">Create Account</h2>
                    <p className="mb-6 text-gray-600">Already have an account? 
                        <span className="text-green-500 cursor-pointer"
                        onClick={() => navigate('/SignIn')}
                        >Sign in</span>
                    </p>
                    <div className="flex gap-4 mb-6">
                        <button
                            onClick={() => handleSwitch('farmer')}
                            className={`${userType === 'farmer' ? 'bg-green-500 text-white' : 'bg-gray-200'} py-2 px-6 rounded-full transition-all hover:scale-105`}
                        >
                            Farmer
                        </button>
                        <button
                            onClick={() => handleSwitch('consumer')}
                            className={`${userType === 'consumer' ? 'bg-green-500 text-white' : 'bg-gray-200'} py-2 px-6 rounded-full transition-all hover:scale-105`}
                        >
                            Consumer
                        </button>
                    </div>
                    <motion.div
                        initial={{ opacity: 0, y: -20 }}
                        animate={{ opacity: 1, y: 0 }}
                        transition={{ duration: 0.5 }}
                        className="space-y-4"
                    >
                        <input type="text" placeholder="First Name" className="w-full border-b-2 p-2 focus:outline-none focus:border-green-500 transition-all" />
                        <input type="text" placeholder="Last Name" className="w-full border-b-2 p-2 focus:outline-none focus:border-blue-500 transition-all" />
                        <input type="text" placeholder="Phone Number" className="w-full border-b-2 p-2 focus:outline-none focus:border-green-500 transition-all" />
                        <input type="text" placeholder="Address" className="w-full border-b-2 p-2 focus:outline-none focus:border-blue-500 transition-all" />
                        {userType === 'consumer' && <input type="email" placeholder="Email ID" className="w-full border-b-2 p-2 focus:outline-none focus:border-green-500 transition-all" />}
                        <button className="w-full bg-green-600 text-white py-2 rounded-md transition-all hover:bg-green-700">Sign Up</button>
                    </motion.div>
                </div>

                {/* Right Side */}
                <div className="w-1/2 bg-gradient-to-br from-green-500 to-green-700 p-10 flex flex-col justify-center text-white">
                    <h2 className="text-3xl font-bold mb-4">Welcome to AgroConnect</h2>
                    <p className="mb-4">Stay connecte do the advance platform for the connectivity between farmers and consumers...</p>
                    {/* <div className="bg-white p-4 rounded-lg shadow-lg text-green-800">
                        <h4 className="text-xl font-semibold">Features</h4>
                        <p></p>
                    </div> */}
                </div>
            </div>
        </div>
    );
}

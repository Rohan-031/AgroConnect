// SignInPage.jsx (React Frontend)
import { useState } from 'react';
import { motion } from 'framer-motion';

export default function SignInPage() {
    const [userType, setUserType] = useState('farmer');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');

    const handleSwitch = (type) => setUserType(type);

    const handleLogin = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/login?emailId=${encodeURIComponent(email)}&password=${encodeURIComponent(password)}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                },
            });
    
            if (response.ok) {
                const result = await response.json(); // Assuming the API returns a Buyer object as JSON
                setMessage(`Welcome, ${result.name}!`); // Adjust as needed
            } else {
                setMessage('Login failed!');
            }
        } catch (error) {
            console.error('Error:', error);
            setMessage('Login failed!');
        }
    };
    

    return (
        <div className="min-h-screen flex items-center justify-center p-0 m-0">
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
                        <input
                            type="email"
                            placeholder="Email ID"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            className="w-full p-2 border rounded"
                        />
                        <input
                            type="password"
                            placeholder="Password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            className="w-full p-2 border rounded"
                        />
                        <button
                            onClick={handleLogin}
                            className="w-full bg-green-600 text-white p-2 rounded hover:bg-green-700 transition"
                        >
                            Sign In
                        </button>
                        {message && <p className="text-center mt-4">{message}</p>}
                    </motion.div>
                </div>
            </div>
        </div>
    );
}
🚀 **Smart Email Assistant**


A Smart Email Assistant built using Spring Boot, Spring AI, and React,
designed to enhance the email experience with intelligent AI-generated replies tailored by tone (formal, casual, friendly, etc.). 
It integrates seamlessly with email platforms like Gmail and Outlook to boost productivity and user interaction.

🔧 **Tech Stack**

Frontend: React, Material UI, Axios

Backend: Java, Spring Boot, Spring AI

AI Integration: Google Gemini APIs (LLM capabilities)

Email Service Integration: Gmail (via Chrome Extension), Outlook (future scope)

API Testing: Postman

Browser Extension: Custom-built Chrome Extension to inject AI reply functionality directly into the Gmail interface

Other Tools: MutationObserver (for DOM manipulation and extension logic)

✨ **Key Features**

✉️ AI-Generated Email Replies
Generate context-aware replies to incoming emails using Google Gemini LLM.

🎯 Tone Selection
Choose from multiple tones (formal, friendly, concise) for replies based on the communication context.

🌐 Gmail Integration via Chrome Extension
Directly embed an "AI Reply" button into Gmail UI using a custom extension, leveraging DOM observation and manipulation.

🧪 Robust Backend APIs
RESTful APIs powered by Spring Boot, tested using Postman, providing scalable and secure endpoints.

⚡ Real-Time Suggestions
Email content dynamically parsed and analyzed to generate real-time smart replies.



🛠️ **Future Enhancements**

📆 Calendar integration for meeting suggestions

🔊 Voice-to-email input

🧠 Learning from past emails to personalize reply tone

🔒 OAuth2 for secure Gmail/Outlook API integration


💡 **How to Use**

Clone the repo and run the Spring Boot backend.

Launch the React frontend.

Install the Chrome extension from the /extension folder.

Open Gmail → Click the "AI Reply" button → Get a smart, tone-adjusted response instantly.

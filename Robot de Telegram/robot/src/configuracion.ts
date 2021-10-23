import { config as variablesentornoConfig } from "dotenv";

// loads environmental variables from .env file
// when in development
if (process.env.NODE_ENV !== 'production') {
  variablesentornoConfig();
}

const config = {
  appUrl: process.env.URL_BOT,
  telegramBot: {
    token: process.env.BOT_TOKEN || 'xxxx',
   // webhookUrl: `${process.env.URL_BOT}${process.env.BOT_TOKEN}` || 'xxxx',
  },
  isProduction: process.env.NODE_ENV === 'production',
  port: process.env.PORT || 4000,
  spoonacular: {
    apiKey: process.env.KEY_APIMUNI || 'xxxx',
  },
};

export default config;